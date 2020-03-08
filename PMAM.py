import random

periods = ['AM', 'PM']
name = '[Alex]'
programName = '[Program]'

def welcome():
    print("""
        Hello! This program will ask you qustions and
        you need to answer them. For example: 2:33 PM answer is
        14:33
        Typing no characters causes the program to exit.
    """)

welcome()

# def get(h,m,p):
    # if m == '0':
        # zero = '0'
    # else:
        # zero = ''
    # if p == 1:
        # if h == '12':
            # h = '00'
        # else:
            # h = int(h)
            # h = str(h + 12)
        # return h + ':' + m + zero
        
    # else:
        # return h + ':' + m + zero
        
def getAMPM(hour, minutes):
    """return list of this form [12-hourTime, 12-hourTime, period, (24-hourTime, 24-hourTime)"""
    time = []
    
    minutes = str(minutes)
    if len(minutes) == 1:
        minutes = '0' + minutes
    
    if 0 < hour < 13:
        h = str(hour)
        time.append(h + ':' + minutes)
        time.append('0' + h + ':' + minutes)
        time.append('AM')
    else:
        h = str(abs(12 - hour))
        time.extend([h + ':' + minutes] * 2)
        time.append('PM')
        
    digTime = str(hour) + ':' + minutes
        
    if hour < 10:
        time.append((digTime, '0' + digTime))
    else:
        time.append((digTime,) * 2)
    
    return time

while True:
    # hour = str(random.randint(1,12))
    # minutes = random.randint(0,59)
    # period = random.randint(0,1)
    # if minutes < 10:
        # minutes = '0' + str(minutes)
    # else:
        # minutes = str(minutes)
    # rightAnswer = get(hour,minutes,period)
    # print(name, hour + ':' + minutes, periods[period], end=' is ')
    # i = input()
    # if i == '':
        # break
    # else:
        # if rightAnswer == i:
            # print(programName, 'Right!')
        # else:
            # print(programName, 'Wrong! It was ' + rightAnswer)
    
    hour = random.randint(0,23)
    minutes = random.randint(0,59)
    ampm = getAMPM(hour, minutes)
    print(ampm[0], ampm[2], end=' is ')
    time = input()
    if time == '':
        break
    if time in ampm[3]:
        print(programName, 'Right!')
    else:
        print(programName, 'Wrong! It was ' + ampm[3][0])
    
