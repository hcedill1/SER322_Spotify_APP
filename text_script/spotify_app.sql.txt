CREATE TABLE ALBUM( Album_ID VARCHAR(50), 
     Title VARCHAR(100), 
     Artist_Name VARCHAR(100), 
     Album_Track VARCHAR(100), 
     Release_Date VARCHAR(30), 
     Genre_ID VARCHAR(50));

CREATE TABLE ARTIST(Artist_ID VARCHAR(50), 
	 Artist_Name VARCHAR(100), 
     Fans VARCHAR(100), 
     Track_Name VARCHAR(100));

CREATE TABLE GENRE(Genre_ID VARCHAR(50), 
     Type VARCHAR(100));

CREATE TABLE PLAYLIST(Playlist_ID VARCHAR(50), 
	  Playlist_Title VARCHAR(100),
	  Playlist_Duration VARCHAR(20), 
	  Date_Added VARCHAR(30), 
	  User_Playlist_ID VARCHAR(50)); 

CREATE TABLE USER(User_Playlist_ID VARCHAR(50), 
	  Followers VARCHAR(100));

 CREATE TABLE POPULARITY(Followers VARCHAR(100), 
	  Likes VARCHAR(30),  
	  Track_Name VARCHAR(100));

 CREATE TABLE TRACKS(Track_Name VARCHAR(100), 
	 Track_Duration VARCHAR(20),
	 Album_ID VARCHAR(50));

ALTER TABLE Album 
     ADD PRIMARY KEY (Album_ID); 

ALTER TABLE Artist 
    ADD PRIMARY KEY (Artist_ID); 

 ALTER TABLE Genre 
    ADD PRIMARY KEY (Genre_ID); 

 ALTER TABLE Tracks 
    ADD PRIMARY KEY (Track_Name);

ALTER TABLE Playlist 
    ADD PRIMARY KEY (Playlist_ID);

ALTER TABLE USER 
    ADD PRIMARY KEY (User_Playlist_ID); 

ALTER TABLE Album 
    ADD FOREIGN KEY(Genre_ID) REFERENCES Genre(Genre_ID); 

ALTER TABLE ARTIST 
    ADD FOREIGN KEY(Track_Name) REFERENCES Tracks(Track_Name);

ALTER TABLE Tracks 
    ADD FOREIGN KEY(Album_ID) REFERENCES Album(Album_ID);

ALTER TABLE Playlist 
    ADD FOREIGN KEY(User_Playlist_ID) REFERENCES User(User_Playlist_ID); 

ALTER TABLE POPULARITY 
    ADD FOREIGN KEY(TRACK_NAME) REFERENCES TRACKS(TRACK_NAME); 


INSERT INTO Genre 
     Values('G1','type1');

INSERT INTO ALBUM 
     VALUES('1111','title1','artist1','album1','release1','g1');

INSERT INTO Tracks 
     VALUES('Track1','123','1111');

INSERT INTO Artist 
    VALUES('AritsID1','ArtistName1','Fans1','Track1');

INSERT INTO User 
    VALUES ('UserID1','Follower1');

INSERT INTO Playlist 
    VALUES ('PlaylistID1','PlaylistTitle1','456','date1','UserID1');

INSERT INTO Popularity 
    VALUES('Followers1','Likes1','Track1');

