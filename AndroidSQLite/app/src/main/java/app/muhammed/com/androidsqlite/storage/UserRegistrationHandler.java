package app.muhammed.com.androidsqlite.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import app.muhammed.com.androidsqlite.models.UserModel;

/**
 * Created by Muhammed on 30/09/17.
 */

public class UserRegistrationHandler extends DataBaseHandler {
    public UserRegistrationHandler(Context context) {
        super(context);
    }

    public boolean insertUserDetails(UserModel userModel) {

        SQLiteDatabase database = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DataBaseManifest.UserTable.Fields.NAME, userModel.getName());
        values.put(DataBaseManifest.UserTable.Fields.EMAIL, userModel.getEmail());
        values.put(DataBaseManifest.UserTable.Fields.PHONE, userModel.getPhone());
        values.put(DataBaseManifest.UserTable.Fields.PLACE, userModel.getPlace());

        long insert = database.insert(DataBaseManifest.UserTable.USER_TABLE, null, values);

        database.close();
        return insert > 0;
    }

    public ArrayList<UserModel> getAllUserDetails() {
        ArrayList<UserModel> userModels = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();

        String query = "SELECT * FROM " + DataBaseManifest.UserTable.USER_TABLE;
        Cursor cursor = database.rawQuery(query, null);



            while (cursor.moveToNext()) {
                UserModel userModel = new UserModel();

                String name = cursor.getString(cursor.getColumnIndex(DataBaseManifest.UserTable.Fields.NAME));

                userModel.setName(name);

                userModels.add(userModel);
            }


//        }

        return userModels;
    }
}
