num=3
nums3=[]
while num<1000:
    nums3.append(num)
    num+=3
num=5
nums5=[]
while num<1000:
    nums5.append(num)
    num+=5
index=0
for num in nums5:
    if num in nums3:
        del nums3[nums3.index(num)]      
print (sum(nums3))+(sum(nums5))
        
    
    
