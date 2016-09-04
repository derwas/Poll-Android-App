I. Description
-----------------

This project is an Android mobile application that creates a poll related to Irish elections in 2016.

I. XML File list
-----------------
activity_main.xml          contains the layout of the first screen of the poll application
poll.xml                   contains the layout of the first part of the poll
poll2.xml                  contains the layout of the second part of the poll 
poll3.xml      	           contains the the layout of the third part of the poll
poll4.xml                  contains the the layout of the final part of the poll
row.xml                    contains the the layout of the listview part of the poll
database.xml           	   contains the layout of the database
statschoice.xml       	   contains the layout of the stats options
stats.xml                  contains the layout of the stats by age and gender
stats1.xml                 contains the layout of the stats by age, gender and occupation
statsresult.xml       	   contains the layout of the result of the stats by age and gender
statsresultjob.xml         contains the layout of the result of the stats by age, gender and occupation
statsresult1.xml           contains the layout of the stats result by number of participants who will/will not vote
statsresult2.xml           contains the layout of the stats result by number of participants who will vote to a particular candidate
AndroidManifest.xml        contains all the intents   


II. Java File list
-----------------
MainActivity.java          contains the first screen of the poll application
Poll.java            	   contains the first part of the poll
Poll2.java                 contains the second part of the poll 
Poll3.java                 contains the third part of the poll
Poll4.java                 contains the final part of the poll
MyDBManager.java           contains the database manager
Database.java              contains the database
Statschoice.java           contains the stats options
Stats.java                 contains the stats by age and gender
Stats1.java                contains the stats by age, gender and occupation
Statsresult.java      	   contains the layout of the result of the stats by age and gender
Statsresultjob.java        contains the layout of the result of the stats by age, gender and occupation
Statsresult1.java          contains the stats result by number of participants who will/will not vote
Statsresult2.java          contains the stats result by number of participants who will vote to a particular candidate

III. Execution
--------------
After running the application, the user will see the main menu as follows:

------------------- Database -------------------

------------------- Start Poll -----------------

----------------- View Statistics --------------

1. Under ---Database ---
	* The user views data stored in the database
	
2. Under ---Start Poll --- 
	* The user views the first part of the poll:
		- Planning to vote
		- Gender
		- Age group
		
	* The user views the second part of the poll:
		- Marital status
		- Children
		- Occupation
		
	* The user views the third part of the poll:
		- Income
		- Favorite political party
		- Comment
		
	* The user views the last part of the poll:
		- Candidates
		
=> After submitting the poll, the user gets back to the home page.

3. Under ---View Statistics ---
	* The user gets a menu of three options:
	
		* option 1*   --- Age + gender ---
		- the user select the preferred age group + gender and submit.
		- The user gets the percentage of voters to each candidate based on the selected age group and gender.

		* option 2*   --- Age + gender + occupation---
		- the user select the preferred age group + gender + occupation and submit.
		- The user gets the percentage of voters to each candidate based on the selected age group, gender and occupation.
		
		* option 3*   --- Voters ---
	        - The user gets the percentage of poll participants who will / will not vote.

	 	* option 4*   --- Candidate stats ---
	        - The user gets the percentage of voters to each candidate.



	