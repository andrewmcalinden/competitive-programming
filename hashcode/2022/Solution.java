import java.util.*;
import java.io.*;

public class Solution {
    public static int time;
    public static HashMap<String, TreeSet<Contributor>> skills;
    public static ArrayList<Project> output;
    public static ArrayList<Project> projects;
    public static ArrayList<Project> cantComplete;
    public static PriorityQueue<Contributor> working;

    public static class Project implements Comparable<Project> {
        String name;
        int d;
        int s;
        int b;
        int r;

        String[] skills;
        int[] levels;
        Contributor[] people;
        boolean[] mentors;

        double baseScorePerDay;
        int timeToChange;
        double scorePerDay;
        int lastTime;

        public Project(String name, int d, int s, int b, int r) {
            this.name = name;
            this.d = d;
            this.s = s;
            this.b = b;
            this.r = r;
            skills = new String[r];
            levels = new int[r];
            people = new Contributor[r];
            mentors = new boolean[r];

            baseScorePerDay = s;
            baseScorePerDay /= d;
            timeToChange = 1 + b - d;
            lastTime = -1;
            scorePerDay = scorePerDay();
        }

        // public double scorePerDay(){
        // //double score = s + Math.min(0, b - (time + d));
        // //return s / d;

        // }

        public double scorePerDay() {
            if (time < timeToChange) {
                lastTime = time;
                return baseScorePerDay;
            }
            if (time <= lastTime) {
                return scorePerDay;
            }
            scorePerDay = (s + b - time - d);
            scorePerDay /= d;
            lastTime = time;
            return scorePerDay;
        }

        // @Override
        // public int compareTo(Project o) {
        // if (scorePerDay() > o.scorePerDay()){
        // return 1;
        // }
        // else if(scorePerDay() < o.scorePerDay()){
        // return -1;
        // }
        // return 0;
        // }

        @Override
        public int compareTo(Project o) {
            double thisScore = scorePerDay();
            double oScore = o.scorePerDay();
            if (thisScore > oScore) {
                return -1;
            }
            if (thisScore < oScore) {
                return 1;
            }
            if (r < o.r) {
                return -1;
            }
            return 1;
        }

        public String toString() {
            return name + ": " + scorePerDay();
        }
    }

    public static class Contributor {
        String name;
        int numSkills;
        boolean currentlyWorking;
        int timeReady;

        HashMap<String, Integer> skills;

        boolean willLearn;
        String skillToLearn;

        public Contributor(String name, int numSkills) {
            this.name = name;
            this.numSkills = numSkills;
            currentlyWorking = false;
            this.timeReady = time;

            skills = new HashMap<>();

            this.willLearn = false;
            this.skillToLearn = "";
        }

        public void setSkills(HashMap<String, Integer> newSkills) {
            skills = newSkills;
        }

        public void finishWorking() {
            currentlyWorking = false;
            if (willLearn) {
                willLearn = false;
                skills.put(skillToLearn, 1 + skills.get(skillToLearn));
            }
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Contributor other = (Contributor) obj;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }
    }

    public static class CompareContributors implements Comparator<Contributor> {

        public String skillToCompare;

        public CompareContributors(String skill) {
            skillToCompare = skill;
        }

        @Override
        public int compare(Contributor arg0, Contributor arg1) {
            int val0 = arg0.skills.get(skillToCompare);
            int val1 = arg1.skills.get(skillToCompare);
            if (val1 != val0) {
                return val0 - val1;
            }
            if (arg0.numSkills != arg1.numSkills) {
                return arg0.numSkills - arg1.numSkills;
            }
            if (arg0.name.compareTo(arg1.name) != 0) {
                return arg0.name.compareTo(arg1.name);
            }
            return 1;
        }

    }

    public static void solve(String inputFile, String outputFile) throws IOException {
        Scanner in = new Scanner(new File(inputFile));
        int c = in.nextInt();
        int p = in.nextInt();

        time = 0;
        skills = new HashMap<>();
        output = new ArrayList<>();
        projects = new ArrayList<>();
        cantComplete = new ArrayList<>();
        working = new PriorityQueue<>((a, b) -> a.timeReady - b.timeReady);

        Contributor[] contributors = new Contributor[c];

        for (int i = 0; i < c; i++) {
            String name = in.next();
            int n = in.nextInt();

            Contributor cur = new Contributor(name, n);
            contributors[i] = cur;
            HashMap<String, Integer> curSkills = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String skill = in.next();
                int l = in.nextInt();
                curSkills.put(skill, l);
            }
            cur.setSkills(curSkills);

            for (String s : cur.skills.keySet()) {
                if (!skills.keySet().contains(s)) {
                    CompareContributors comp = new CompareContributors(s);
                    TreeSet<Contributor> start = new TreeSet<>(comp);
                    start.add(cur);
                    skills.put(s, start);
                } else {
                    TreeSet<Contributor> hasStuff = skills.get(s);
                    hasStuff.add(cur);
                    skills.put(s, hasStuff);
                }
            }
        }

        for (String key : skills.keySet()) {
            for (Contributor cur : contributors) {
                cur.skills.putIfAbsent(key, 0);
                skills.get(key).add(cur);
            }
        }

        for (int i = 0; i < p; i++) {
            String name = in.next();
            int d = in.nextInt();
            int s = in.nextInt();
            int b = in.nextInt();
            int r = in.nextInt();

            Project cur = new Project(name, d, s, b, r);
            for (int j = 0; j < r; j++) {
                String skill = in.next();
                int l = in.nextInt();
                cur.skills[j] = skill;
                cur.levels[j] = l;
            }
            projects.add(cur);
        }
        in.close();

        // while(projects.size() > 0){
        // Project best = projects.get(0);

        // boolean works = true;
        // for(int i = 0; i < best.r; i++){
        // int levelNeeded = best.levels[i];
        // String s = best.skills[i];
        // HashMap<String, Integer> leastSkillsNeeded = new HashMap<>();
        // leastSkillsNeeded.put(s, levelNeeded);

        // Contributor min = new Contributor("", 1);
        // min.setSkills(leastSkillsNeeded);

        // Contributor leastCost = skills.get(s).ceiling(min);
        // while(leastCost != null && leastCost.currentlyWorking){
        // leastCost = skills.get(s).higher(leastCost);
        // }
        // if (leastCost == null) {
        // cantComplete.add(best);
        // projects.remove(0);
        // works = false;
        // break;
        // }
        // else{
        // best.people[i] = leastCost;
        // leastCost.currentlyWorking = true;
        // leastCost.timeReady = time + best.d;
        // working.offer(leastCost);
        // }
        // }
        // if (works){
        // output.add(best);
        // }
        // }

        completeProjects();

        int lastNumWorking = working.size();
        while (!working.isEmpty()) {
            int newTime = working.peek().timeReady;
            if (newTime > time) {
                if (working.size() != lastNumWorking) {
                    projects = cantComplete;
                    cantComplete = new ArrayList<>();
                    completeProjects();
                }
            }
            lastNumWorking = working.size();
            Contributor worker = working.poll();
            time = worker.timeReady;
            worker.finishWorking();
        }

        // time += best.d;
        // for (Contributor cont : best.people) {
        // cont.currentlyWorking = false;
        // }
        // Collections.sort(projects);

        FileWriter writer = new FileWriter(outputFile);
        writer.write(output.size() + "\n");
        for (Project pro : output) {
            writer.write(pro.name + "\n");
            for (int i = 0; i < pro.r; i++) {
                String person = pro.people[i].name;
                writer.write(person + " ");
            }
            writer.write("\n");
        }
        writer.close();
    }

    public static void completeProjects() {
        while (!projects.isEmpty()) {
            Collections.sort(projects);
            Project best = projects.get(0);
            if (best.scorePerDay() <= 0) {
                projects.remove(0);
                continue;
            }

            int[] oldLevels = best.levels;
            boolean[] oldMentors = best.mentors;
            boolean works = true;
            for (int i = 0; i < best.r; i++) {
                int levelNeeded = best.levels[i];
                String s = best.skills[i];
                HashMap<String, Integer> leastSkillsNeeded = new HashMap<>();
                leastSkillsNeeded.put(s, levelNeeded);

                Contributor min = new Contributor("", 1);
                min.setSkills(leastSkillsNeeded);

                Contributor leastCost = skills.get(s).ceiling(min);
                while (leastCost != null && leastCost.currentlyWorking) {
                    leastCost = skills.get(s).higher(leastCost);
                }
                if (leastCost == null) {
                    cantComplete.add(best);
                    works = false;
                    break;
                } else {
                    best.people[i] = leastCost;
                    for (int j = 0; j < best.r; j++) {
                        if (j == i) {
                            continue;
                        }
                        int addedSkill = leastCost.skills.get(best.skills[j]);
                        if (best.levels[j] > 0 && addedSkill >= best.levels[j] && !best.mentors[j]) {
                            best.levels[j]--;
                            best.mentors[j] = true;
                        }
                    }
                    if (leastCost.skills.get(s) <= oldLevels[i]) {
                        leastCost.willLearn = true;
                        leastCost.skillToLearn = s;
                    }
                    leastCost.currentlyWorking = true;
                    leastCost.timeReady = time + best.d;

                }
            }
            if (works) {
                output.add(best);
                for (Contributor worker : best.people) {
                    working.offer(worker);
                }
            } else {
                best.mentors = oldMentors;
                best.levels = oldLevels;
                for (Contributor worker : best.people) {
                    if (worker != null) {
                        worker.currentlyWorking = false;
                        worker.timeReady = time;
                        worker.willLearn = false;
                        worker.skillToLearn = "";
                    }
                }
            }
            projects.remove(0);
        }
    }

    public static void main(String[] args) throws IOException {

        String inputPath = "";
        String inputExt = ".in.txt";
        String outputPath = "";
        String outputExt = ".out.txt";

        String[] dataSets = {
                "a_an_example",
                "b_better_start_small",
                "c_collaboration",
                "d_dense_schedule",
                "e_exceptional_skills",
                "f_find_great_mentors"
        };

        for (String dataSet : dataSets) {
            System.out.println("Solving " + dataSet + "...");
            solve(inputPath + dataSet + inputExt, outputPath + dataSet + outputExt);
            System.out.println("Solved " + dataSet);
        }
    }
}