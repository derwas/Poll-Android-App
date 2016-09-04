package com.example.mallannius.poll;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBManager {


    //Create KEY_ROWID for each element
    public static final String KEY_ROWID = "_id";
    public static final String KEY_VOTE = "Vote";
    public static final String KEY_GENDER = "Gender";
    public static final String KEY_AGE = "Age";
    public static final String KEY_MARITAL = "Marital";
    public static final String KEY_CHILDREN = "Children";
    public static final String KEY_OCCUPATION = "Occupation";
    public static final String KEY_INCOME = "Income";
    public static final String KEY_PARTY = "Party";
    public static final String KEY_COMMENT = "Comment";
    public static final String KEY_CANDIDATES = "Candidates";
    public static final String KEY_CHOICE = "Choice";


// Assign name to Database and Database table
    private static final String DATABASE_NAME = "Poll";
    private static final String DATABASE_TABLE = "Poll_Details";
    private static final int DATABASE_VERSION = 1;


    private static final String DATABASE_CREATE = "create table Poll_Details " +
            "(_id integer primary key autoincrement, " +
            "Vote text not null, " + "Gender text not null, " +
            "Age text not null, " + "Marital text not null, " + "Children text not null, " +
            "Occupation text not null, " + "Income text not null, " + "Party text not null, " +
            "Comment text not null, " + "Candidates text not null, " + "Choice text not null )";

    private final Context context;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;


    public MyDBManager(Context ctx) {

        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }


    //
    private static class DatabaseHelper extends SQLiteOpenHelper {

        //
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME,
                    null, DATABASE_VERSION);
        }


        @Override
        //
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(DATABASE_CREATE);
        }

        @Override

        //
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion) {
            // whatever is to be changed on dB structure

        }
    }

    public MyDBManager open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //
    public void close() {
        DBHelper.close();
    }

    // Insert new data to Poll
    public long insertPoll(String Vote, String Gender, String Age, String Marital,
                           String Children, String Occupation, String Income, String Party,
                           String Comment, String Candidates, String Choice)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_VOTE, Vote);
        initialValues.put(KEY_GENDER, Gender);
        initialValues.put(KEY_AGE, Age);
        initialValues.put(KEY_MARITAL, Marital);
        initialValues.put(KEY_CHILDREN, Children);
        initialValues.put(KEY_OCCUPATION, Occupation);
        initialValues.put(KEY_INCOME, Income);
        initialValues.put(KEY_PARTY, Party);
        initialValues.put(KEY_COMMENT, Comment);
        initialValues.put(KEY_CANDIDATES, Candidates);
        initialValues.put(KEY_CHOICE, Choice);

        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    //Delete data per row
    public boolean deleteTask(long rowId) {
        //
        return db.delete(DATABASE_TABLE, KEY_ROWID +
                "=" + rowId, null) > 0;
    }

    // Get All data from the table
    public Cursor getAllTask() {
        return db.query(DATABASE_TABLE, new String[]{
                        KEY_ROWID,
                        KEY_VOTE,
                        KEY_GENDER,
                        KEY_AGE,
                        KEY_MARITAL,
                        KEY_CHILDREN,
                        KEY_OCCUPATION,
                        KEY_INCOME,
                        KEY_PARTY,
                        KEY_COMMENT,
                        KEY_CANDIDATES,
                        KEY_CHOICE
                },
                null,
                null,
                null,
                null,
                null);
    }
    // Get Statistics from the table
    public Cursor getStat(long rowId) throws android.database.SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_VOTE,
                                KEY_GENDER,
                                KEY_AGE,
                                KEY_MARITAL,
                                KEY_CHILDREN,
                                KEY_OCCUPATION,
                                KEY_INCOME,
                                KEY_PARTY,
                                KEY_COMMENT,
                                KEY_CANDIDATES,
                                KEY_CHOICE
                        },
                        KEY_ROWID + "=" + rowId,
                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    // Get poll results by selected Age range
    public Cursor getPollbyAge(String Age) throws SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_VOTE,
                                KEY_AGE,
                                KEY_GENDER,
                                KEY_MARITAL,
                                KEY_CHILDREN,
                                KEY_OCCUPATION,
                                KEY_INCOME,
                                KEY_PARTY,
                                KEY_COMMENT,
                                KEY_CANDIDATES,
                                KEY_CHOICE

                        },
                        KEY_AGE + "=\"" + Age + "\"",

                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    // Get poll results based on whether people participating in the poll will vote or not

    public Cursor getPollbyVoter(String Vote) throws SQLException
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {
                                KEY_ROWID,
                                KEY_VOTE,
                                KEY_AGE,
                                KEY_GENDER,
                                KEY_MARITAL,
                                KEY_CHILDREN,
                                KEY_OCCUPATION,
                                KEY_INCOME,
                                KEY_PARTY,
                                KEY_COMMENT,
                                KEY_CANDIDATES,
                                KEY_CHOICE

                        },
                        KEY_VOTE +"=\"" + Vote +"\"",

                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    // Get poll results by selected candidates
    public Cursor getPollbyCandidates(String Candidates) throws SQLException
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {
                                KEY_ROWID,
                                KEY_VOTE,
                                KEY_AGE,
                                KEY_GENDER,
                                KEY_MARITAL,
                                KEY_CHILDREN,
                                KEY_OCCUPATION,
                                KEY_INCOME,
                                KEY_PARTY,
                                KEY_COMMENT,
                                KEY_CANDIDATES,
                                KEY_CHOICE

                        },
                        KEY_CANDIDATES +"=\"" + Candidates +"\"",

                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    // Get poll results by selected Gender

    public Cursor getPollbyGender(String Gender) throws SQLException
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {
                                KEY_ROWID,
                                KEY_VOTE,
                                KEY_AGE,
                                KEY_GENDER,
                                KEY_MARITAL,
                                KEY_CHILDREN,
                                KEY_OCCUPATION,
                                KEY_INCOME,
                                KEY_PARTY,
                                KEY_COMMENT,
                                KEY_CANDIDATES,
                                KEY_CHOICE

                        },
                        KEY_GENDER +"=\"" + Gender +"\"",

                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }
    // Get poll results by selected Age range,gender and candidates
    public Cursor getPollbyGenderAndAge(String Gender, String Age, String Candidate) throws SQLException
    {
        Cursor mCursor = db.query(true, DATABASE_TABLE, new String[] {
                                KEY_ROWID,
                                KEY_VOTE,
                                KEY_AGE,
                                KEY_GENDER,
                                KEY_MARITAL,
                                KEY_CHILDREN,
                                KEY_OCCUPATION,
                                KEY_INCOME,
                                KEY_PARTY,
                                KEY_COMMENT,
                                KEY_CANDIDATES,
                                KEY_CHOICE

                        },
                        KEY_GENDER +"=\"" + Gender +"\"" + " AND "+ KEY_AGE +"=\"" + Age +"\"" + " AND "+ KEY_CANDIDATES +"=\"" + Candidate +"\"",

                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;


    }
    public Cursor getPollbyGenderAndAgeAndOccupation(String Gender, String Age,String Occupation, String Candidate) throws SQLException
    {
        Cursor mCursor = db.query(true, DATABASE_TABLE, new String[] {
                        KEY_ROWID,
                        KEY_VOTE,
                        KEY_AGE,
                        KEY_GENDER,
                        KEY_MARITAL,
                        KEY_CHILDREN,
                        KEY_OCCUPATION,
                        KEY_INCOME,
                        KEY_PARTY,
                        KEY_COMMENT,
                        KEY_CANDIDATES,
                        KEY_CHOICE

                },
                KEY_GENDER +"=\"" + Gender +"\"" + " AND "+ KEY_AGE +"=\"" + Age +"\"" + " AND "+ KEY_OCCUPATION +"=\"" + Occupation +"\"" + " AND "+ KEY_CANDIDATES +"=\"" + Candidate +"\"",

                null,
                null,
                null,
                null,
                null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;


    }




}







