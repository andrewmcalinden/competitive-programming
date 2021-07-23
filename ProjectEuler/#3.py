divisor=1
while divisor<600851475143:
    if 600851475143%divisor==0:
        factors=[]
        divisor2=1
        while divisor2<=divisor:
            if divisor%divisor2==0:
                factors.append(divisor2)
            divisor2+=1
        if len(factors)==2:
            print divisor        
    divisor+=2
