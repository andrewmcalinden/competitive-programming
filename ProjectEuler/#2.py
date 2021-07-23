nums=[1,2]
index=2
num=0
while num<4000000:
    num=(nums[index-2])+(nums[index-1])
    nums.append(num)
    index+=1
index=0
while index<len(nums):
    if nums[index]>=4000000 or not nums[index]%2==0:
        del nums[index]
    else:
        index+=1
print sum(nums)


