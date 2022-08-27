package eleicao;

public class Pesquisa {
	
	private int id;
	private String instituto;
	private String data;
	private String local;
	private int idadeMedia;
	private TipoPesquisa tipoPesquisa;
	private FormatoPesquisa formatoPesquisa;
	
	
	public Pesquisa(int id, String instituto, String data, String local, int idadeMedia, TipoPesquisa tipoPesquisa,
			FormatoPesquisa formatoPesquisa) {
		this.id = id;
		this.instituto = instituto;
		this.data = data;
		this.local = local;
		this.idadeMedia = idadeMedia;
		this.tipoPesquisa = tipoPesquisa;
		this.formatoPesquisa = formatoPesquisa;
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

	public TipoPesquisa getTipoPesquisa() {
		return tipoPesquisa;
	}

	public void setTipoPesquisa(TipoPesquisa tipoPesquisa) {
		this.tipoPesquisa = tipoPesquisa;
	}

	public FormatoPesquisa getFormatoPesquisa() {
		return formatoPesquisa;
	}

	public void setFormatoPesquisa(FormatoPesquisa formatoPesquisa) {
		this.formatoPesquisa = formatoPesquisa;
	}
}
