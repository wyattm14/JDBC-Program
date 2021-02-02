CREATE TABLE IF NOT EXISTS Fighter (
    FirstName Char(100) NOT NULL,
    LastName Char(100) NOT NULL,
    Opponent CHAR(100),
    Stance Char(100),
    FighterID int primary key,
    Salary INT,
    Location Char(100)

);

CREATE TABLE IF NOT EXISTS Stadium (
    Capacity INT,
    City CHAR(100),
    State CHAR(100),
    StadiumName CHAR(200) primary key,
    UNIQUE (StadiumName)
);

CREATE TABLE IF NOT EXISTS Event (
    EventID INT primary key,
    EventName Char(100),
    NumEvent INT
);

CREATE TABLE IF NOT EXISTS Sales (
    SaleId int primary key,
    QuantSold int,
    AvgTicketPrice int,
    TotalCost int,
    Revenue int,
    EventID int,
    FOREIGN KEY (EventID) REFERENCES Event (EventID)
);

CREATE TABLE IF NOT EXISTS StartTime (
    StartTimeId int primary key,
  	start_time int,
    time_per_match int,
    end_time int
);

CREATE TABLE IF NOT EXISTS Commercial (
    AdComp CHAR(100),
    NumAds int,
    AmtPaid int,
    AirTime int,
    TransactionID int primary key,
    EventID int,
    PaidTo CHAR(100),
    FOREIGN KEY (EventID) REFERENCES Event (EventID)
);

CREATE TABLE IF NOT EXISTS Station (
    StationName Char(100),
    StationID int primary key
);

CREATE TRIGGER revenue_trig
after INSERT
ON StartTime
FOR EACH ROW
UPDATE Stadium
SET StadiumName = StadiumName + ", " + City + ", " + State;
