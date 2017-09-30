package app.muhammed.com.androidsqlite.storage;

/**
 * Created by Muhammed on 30/09/17.
 */

public class DataBaseManifest {
    public static final String DB_NAME = "SQLiteDb";
    public static final int VERSION = 1;

    public static class UserTable {
        public static final String USER_TABLE = "user_table";

        public static final String CREATE_TABLE = " CREATE TABLE " +
                USER_TABLE + "(" + Fields.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Fields.NAME + " TEXT," +
                Fields.EMAIL + " TEXT," +
                Fields.PHONE + " TEXT," +
                Fields.PLACE + " TEXT)";

        public static class Fields {
            public static final String ID = "id";
            public static final String NAME = "name";
            public static final String EMAIL = "email";
            public static final String PHONE = "phone";
            public static final String PLACE = "place";
        }
    }

}
