import random
import string
import datetime

def get_random_string(length):
    letters = string.ascii_lowercase
    return ''.join(random.choice(letters) for i in range(length))

def insertFighter(file):
    Stances = ["Orthodox", "Switch", "Unorthodox", "SouthPaw"]
    Salaries = [10000,20000,30000,40000,50000]
    file.write('INSERT INTO Fighter VALUES')
    for i in range(20000):
        FirstName = (get_random_string(4)).capitalize()
        LastName = (get_random_string(4)).capitalize()
        Opponent = (get_random_string(4)).capitalize()
        Location = (get_random_string(4)).capitalize()

        lastChar = ',' if i < 19999 else ';'
        file.write(f'("{FirstName}", "{LastName}", "{Opponent}", "{Stances[i%4]}", {i}, {Salaries[i%5]}, "{Location}"){lastChar}\n')

def insertStadium(file):
    Capacity = [30000,20000,40000,50000]
    file.write("INSERT INTO Stadium VALUES \n")
    for i in range(20000):
        City = get_random_string(6)
        State = get_random_string(7)
        StadiumName = get_random_string(6)
        lastChar = ',' if i < 19999 else ';'
        file.write(f'({Capacity[i%4]}, "{City}", "{State}", "{StadiumName}"){lastChar}\n')

def insertEvent(file):
    file.write("INSERT INTO Event VALUES \n")
    num_events = [9,10,11,12]
    eventIDs = []
    for i in range(1000000):
        EventName = get_random_string(8)
        lastChar = ',' if i < 999999 else ';'
        file.write(f'({i}, "{EventName}", {num_events[i%4]}){lastChar}\n')
        eventIDs.append(i)

    return eventIDs

def insertSales(file):
    file.write("INSERT INTO Sales VALUES \n")
    QuantSold = [10245,22234,32123,41323]
    AvgTicketPrice = [40,50,60,70,80]
    TotalCost = [20000,30000,40000,50000,60000,70000]
    Revenue = 1000000
    for i in range(50000):
        lastChar = ',' if i < 49999 else ';'
        file.write(f'({i},{QuantSold[i%4]}, {AvgTicketPrice[i%5]}, {TotalCost[i%6]}, {Revenue}, {eventIDs[i%50001]}){lastChar}\n')

# what to do with variable that is a foreign key

def insertStartTime(file):
    start_time = [6,7,8,9,10,11]
    time_per_match = [15,25]
    end_time = [9,10,11,12]
    file.write("INSERT INTO StartTime VALUES \n")
    for i in range(110000):
        lastChar = ',' if i < 109999 else ';'
        file.write(f'({i},{start_time[i%6]}, {time_per_match[i%2]}, {end_time[i%4]}){lastChar}\n')

def insertCommercial(file):
    file.write("INSERT INTO Commercial VALUES \n")
    NumAds = [4,5,6]
    AmtPaid = [5000,6000,7000,8000]
    AirTime = [5,10,20,30,40]
    PaidTo = ["ESPN", "TNT", "HBO", "FOX"]
    for i in range(90000):
        AdComp = get_random_string(6)
        lastChar = ',' if i < 89999 else ';'
        file.write(f'("{AdComp}", {NumAds[i%3]}, {AmtPaid[i%4]}, {AirTime[i%5]}, {i}, {eventIDs[i%90001]},"{PaidTo[i%4]}"){lastChar}\n')

def insertStation(file):
    file.write("INSERT INTO Station VALUES \n")
    StationName = ["ESPN", "TNT", "HBO", "FOX"]
    for i in range(10000):
        lastChar = ',' if i < 9999 else ';'
        file.write(f'("{StationName[i%4]}", {i}){lastChar}\n')


with open('data.sql', 'w') as file:
    insertFighter(file)
    insertStadium(file)
    eventIDs = insertEvent(file)
    insertSales(file)
    insertCommercial(file)
    insertStartTime(file)
    insertStation(file)
