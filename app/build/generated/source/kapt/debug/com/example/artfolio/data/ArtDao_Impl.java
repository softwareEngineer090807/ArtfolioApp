package com.example.artfolio.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.example.artfolio.model.ArtItem;
import java.lang.Class;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class ArtDao_Impl implements ArtDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<ArtItem> __insertAdapterOfArtItem;

  public ArtDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfArtItem = new EntityInsertAdapter<ArtItem>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `art_table` (`id`,`title`,`description`,`imageResId`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, @NonNull final ArtItem entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getTitle());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getDescription());
        }
        statement.bindLong(4, entity.getImageResId());
      }
    };
  }

  @Override
  public Object insertAll(final List<ArtItem> artItems,
      final Continuation<? super Unit> $completion) {
    if (artItems == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfArtItem.insert(_connection, artItems);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public LiveData<List<ArtItem>> getAllArt() {
    final String _sql = "SELECT * FROM art_table";
    return __db.getInvalidationTracker().createLiveData(new String[] {"art_table"}, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfImageResId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "imageResId");
        final List<ArtItem> _result = new ArrayList<ArtItem>();
        while (_stmt.step()) {
          final ArtItem _item;
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          final String _tmpTitle;
          if (_stmt.isNull(_columnIndexOfTitle)) {
            _tmpTitle = null;
          } else {
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
          }
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final int _tmpImageResId;
          _tmpImageResId = (int) (_stmt.getLong(_columnIndexOfImageResId));
          _item = new ArtItem(_tmpId,_tmpTitle,_tmpDescription,_tmpImageResId);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
