package com.zype.android.ui.Gallery.Model;

import com.zype.android.Db.Entity.Playlist;
import com.zype.android.Db.Entity.Video;

import java.util.List;

/**
 * Created by Evgeny Cherkasov on 12.06.2018.
 */
public class GalleryRow {
    public Playlist playlist;
    public List<Video> videos;
    public List<Playlist> nestedPlaylists;

    public GalleryRow(Playlist playlist) {
        this.playlist = playlist;
    }
}
