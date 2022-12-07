package com.backend.postapiserver.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Viewer")
@Data
@NoArgsConstructor
public class Viewer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nickName;
    @ManyToMany
    @JoinTable(name = "followed_streams", joinColumns = @JoinColumn(name = "viewer_id"), inverseJoinColumns = @JoinColumn(name = "stream_id"))
    private List<Stream> followedStreams = new ArrayList<>();

    public Viewer(String nickName) {
        this.nickName = nickName;
    }

    public void followStrem(Stream stream) {
        followedStreams.add(stream);
    }
}
