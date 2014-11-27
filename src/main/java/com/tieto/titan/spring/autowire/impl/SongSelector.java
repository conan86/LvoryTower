package com.tieto.titan.spring.autowire.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class SongSelector {
	
	@Resource(name="songs")
	private List<String> songs = new ArrayList<String>();

	public String selectSong() {
		if (songs != null && songs.size() > 0) {
			Random random = new Random();
			int index = 0;
			index = random.nextInt(songs.size());
			return songs.get(index);
		}
		return null;
	}

	public static void main(String[] args) {
		SongSelector selector = new SongSelector();
		List<String> songs = new ArrayList<String>();
		songs= new ArrayList<String>();
		songs.add("My Heart will go on");
		songs.add("Just one last dance");
		songs.add("Little house");
		songs.add("Prety boy");
		songs.add("Tonigt I Celebrate My Love");
		songs.add("I Believe I Can Fly");
		selector.setSongs(songs);
		for (int i = 0; i < 100; i++) {
			System.out.println(selector.selectSong());
		}
	}

	public List<String> getSongs() {
		return songs;
	}
	
	public void setSongs(List<String> songs) {
		this.songs = songs;
	}
}
