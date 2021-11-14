num2=999
count=0
count2=0
while num2>99:
    num1=999
    while num1>99:
        str_list=[]
        str_list_reverse=[]
        product=str(num1*num2)
        for number in product:
            str_list.append(number)
            str_list_reverse.append(number)
        str_list_reverse.reverse()
        if str_list_reverse==str_list:
            print product
        num1-=1
    num2-=1
    
    
    
    
        
    
