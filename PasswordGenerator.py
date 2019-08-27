import random as r

symbols = '%*)?@#$~ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789'

def make(size,useSings,useUppercase, useLowercase, useNumbers):
    password = ''
    i = 0
    while i != size:
        i += 1
        randomnum = r.randint(0, len(symbols) - 1)

        if not useSings and randomnum < 8:
            i -= 1
            continue
        elif not useUppercase and randomnum > 7 and randomnum < 34:
            i -= 1
            continue
        elif not useLowercase and randomnum > 33 and randomnum < 60:
            i -= 1
            continue
        elif not useNumbers and randomnum > 59:
            i -= 1
            continue
        else:
            password += symbols[randomnum]
    return password
