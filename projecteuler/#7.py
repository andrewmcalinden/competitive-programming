'''
nums=[]
num=1
while len(nums)<10002:
    print num
    factors=[]
    divisor=1
    while divisor<=num:
        if num%divisor==0:
            factors.append(divisor)
        divisor+=1
    if len(factors)==2:
        nums.append(num)
    num+=1
print nums[-1]
'''

nums=range(10000)

index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%3==0:
        del nums[index]
    else:
        index+=1
nums.append(3)
index=0
while index<len(nums):
    if nums[index]%5==0:
        del nums[index]
    else:
        index+=1
nums.append(5)
index=0
while index<len(nums):
    if nums[index]%7==0:
        del nums[index]
    else:
        index+=1
index=0
nums.append(7)
while index<len(nums):
    if nums[index]%11==0:
        del nums[index]
    else:
        index+=1
index=0
nums.append(11)
while index<len(nums):
    if nums[index]%13==0:
        del nums[index]
    else:
        index+=1
index=0
nums.append(13)
while index<len(nums):
    if nums[index]%17==0:
        del nums[index]
    else:
        index+=1
index=0
nums.append(17)
while index<len(nums):
    if nums[index]%19==0:
        del nums[index]
    else:
        index+=1
index=0
nums.append(19)
while index<len(nums):
    if nums[index]%23==0:
        del nums[index]
    else:
        index+=1
index=0
nums.append(23)
while index<len(nums):
    if nums[index]%29==0:
        del nums[index]
    else:
        index+=1
index=0
nums.append(29)
while index<len(nums):
    if nums[index]%31==0:
        del nums[index]
    else:
        index+=1
index=0
nums.append(31)
while index<len(nums):
    if nums[index]%37==0:
        del nums[index]
    else:
        index+=1
nums.append(37)
index=0
while index<len(nums):
    if nums[index]%39==0:
        del nums[index]
    else:
        index+=1
nums.append(39)
index=0
while index<len(nums):
    if nums[index]%41==0:
        del nums[index]
    else:
        index+=1
nums.append(41)
index=0
while index<len(nums):
    if nums[index]%43==0:
        del nums[index]
    else:
        index+=1
nums.append(43)
index=0
while index<len(nums):
    if nums[index]%47==0:
        del nums[index]
    else:
        index+=1
nums.append(47)
index=0
while index<len(nums):
    if nums[index]%51==0:
        del nums[index]
    else:
        index+=1
nums.append(51)
index=0
while index<len(nums):
    if nums[index]%53==0:
        del nums[index]
    else:
        index+=1
nums.append(53)
index=0
while index<len(nums):
    if nums[index]%57==0:
        del nums[index]
    else:
        index+=1
nums.append(57)
index=0
while index<len(nums):
    if nums[index]%59==0:
        del nums[index]
    else:
        index+=1
nums.append(59)
index=0
while index<len(nums):
    if nums[index]%61==0:
        del nums[index]
    else:
        index+=1
nums.append(61)
index=0
while index<len(nums):
    if nums[index]%67==0:
        del nums[index]
    else:
        index+=1
nums.append(67)
index=0
while index<len(nums):
    if nums[index]%71==0:
        del nums[index]
    else:
        index+=1
nums.append(71)
index=0
while index<len(nums):
    if nums[index]%73==0:
        del nums[index]
    else:
        index+=1
nums.append(73)
index=0
while index<len(nums):
    if nums[index]%79==0:
        del nums[index]
    else:
        index+=1
nums.append(79)
index=0
while index<len(nums):
    if nums[index]%83==0:
        del nums[index]
    else:
        index+=1
nums.append(83)
index=0
#THIS IS WHERE YOU LEFT 0FF
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append()
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)
index=0
while index<len(nums):
    if nums[index]%2==0:
        del nums[index]
    else:
        index+=1
nums.append(2)





nums.sort()
