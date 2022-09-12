package model;

import java.time.LocalDate;

public class Pesquisa  {
	
	private int id;
	private String instituto;
	private String data;
	private String local;
	private int idadeMedia;
	private String tipoPesquisa;
	private String formatoPesquisa;
	
	
	public Pesquisa(int id, String instituto, String data, String local, int idadeMedia, String tipoPesquisa, String formatoPesquisa) {
		this.id = id;
		this.instituto = instituto;
		this.data = data;
		this.local = local;
		this.idadeMedia = idadeMedia;
		this.tipoPesquisa = tipoPesquisa;
		this.formatoPesquisa = formatoPesquisa;
	}
	
	public Pesquisa( String instituto, String data, String local, int idadeMedia, String tipoPesquisa, String formatoPesquisa) {
		this.instituto = instituto;
		this.data = data;
		this.local = local;
		this.idadeMedia = idadeMedia;
		this.tipoPesquisa = tipoPesquisa;
		this.formatoPesquisa = formatoPesquisa;
	}
	public Pesquisa() {
		
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstituto() {
		return instituto;
	}

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public int getIdadeMedia() {
		return idadeMedia;
	}

	public void setIdadeMedia(int idadeMedia) {
		this.idadeMedia = idadeMedia;
	}

	public String getTipoPesquisa() {
		return tipoPesquisa;
	}

	public void setTipoPesquisa(String tipoPesquisa) {
		this.tipoPesquisa = tipoPesquisa;
	}

	public String getFormatoPesquisa() {
		return formatoPesquisa;
	}

	public void setFormatoPesquisa(String formatoPesquisa) {
		this.formatoPesquisa = formatoPesquisa;
	}
	
	public String toString(){
		return "Pesquisa N° " + this.id + ", " + this.formatoPesquisa + "! De forma " + this.tipoPesquisa + "!"; 
	}
		
	}
