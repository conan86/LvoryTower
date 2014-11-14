package com.tieto.titan.spring.ioc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SongSelector {

	private List<String> songs = null;;

	public String selectSong() {
		if (songs != null && songs.size() > 0) {
			Random random = new Random();
			int index = 0;
			index = random.nextInt(songs.size());
			// System.out.println(index);
			return songs.get(index);

		}
		return null;
	}

	public static void main(String[] args) {
		SongSelector selector = new SongSelector();
		List<String> list = new ArrayList<String>();
		selector.setSongs(list);
		list.add("My Heart will go on");
		list.add("Just one last dance");
		list.add("Little house");
		list.add("Prety boy");
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
