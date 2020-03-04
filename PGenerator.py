#PGenerator Version 12Jan2020 as V4
import random as r

#DEFAULTS:
DEFAULT = [
'!@#$%^&*()"\'',
'ABCDEFGHIJKLMNOPQRSTUVWXYZ',
'abcdefghijklmnopqrstuvwxyz',
'1234567890'
]
CONDITIONS = [False,False,False,True]

def make(size=12, conditions=CONDITIONS):
    """return a password"""

    strs = []
    password = ''

    for i in range(len(conditions)):
        accept = conditions[i]
        if accept == True:
            strs.append(DEFAULT[i])

    for i in range(size):
        select = r.randint(0,len(strs) - 1)
        take = r.randint(0,len(strs[select]) - 1)
        password += strs[select][take]
        
    return password

if __name__ == '__main__':
    print(make())
    while True:
        pass
