package app.pam.aplikacjapam

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.view.View
import android.widget.Toast

class DataBaseHelper(context: Context, name: String?, factory:
SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context,
    DATABASE_NAME, factory, DATABASE_VERSION) {

    val TABLE_SONGS = "songs"
    val COLUMN_ID = "song_id"
    val COLUMN_BAND_NAME = "song_band_name"
    val COLUMN_SONG_NAME = "song_name"
    val COLUMN_ALBUM_NAME = "song_album_name"
    val COLUMN_DATE_OF_RECORDING = "song_date_of_recording"
    val COLUMN_SONG_IMAGE = "song_song_image"
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "playersDataBase.db"
    }

    override fun onCreate(database: SQLiteDatabase) {
        val CREATE_SONGS_TABLE = ("CREATE TABLE " +
                TABLE_SONGS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_SONG_NAME + " TEXT,"
                + COLUMN_BAND_NAME + " TEXT,"
                + COLUMN_ALBUM_NAME + " TEXT,"
                + COLUMN_DATE_OF_RECORDING + " INTEGER,"
                + COLUMN_SONG_IMAGE + " TEXT" + ")"
                )
        database.execSQL(CREATE_SONGS_TABLE)
    }

    override fun onUpgrade(database: SQLiteDatabase, oldVersion: Int, newVersion: Int)
    {
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_SONGS)
        onCreate(database)
    }

    fun addSong(song: Song) {
        val data = ContentValues()
        data.put(COLUMN_SONG_NAME, song.name)
        data.put(COLUMN_BAND_NAME, song.bandName)
        data.put(COLUMN_ALBUM_NAME, song.albumName)
        data.put(COLUMN_DATE_OF_RECORDING, song.dateOfRecording)
        data.put(COLUMN_SONG_IMAGE, song.songImage)
        val database = this.writableDatabase
        database.insert(TABLE_SONGS, null, data)
        database.close()
    }

    fun findSong(songName: String, songBandName: String): Song? {
        val query =
            "SELECT * FROM $TABLE_SONGS WHERE $COLUMN_SONG_NAME = \"$songName\"" + "and $COLUMN_BAND_NAME = \"$songBandName\""
        val database = this.writableDatabase
        val cursor = database.rawQuery(query, null)
        var song: Song? = null
        if (cursor.moveToFirst()) {
            cursor.moveToFirst()
            val id = Integer.parseInt(cursor.getString(0))
            val searchedSongName = cursor.getString(1)
            val searchedSongBandName = cursor.getString(2)
            val searchedSongAlbumName = cursor.getString(3)
            val searchedSongDate = cursor.getString(4)
            val searchedSongImage = cursor.getString(5)
            song = Song(id, searchedSongName, searchedSongBandName, searchedSongAlbumName, searchedSongDate, searchedSongImage)
            cursor.close()
        }
        database.close()
        return song
    }

}