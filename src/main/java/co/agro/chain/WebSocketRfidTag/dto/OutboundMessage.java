package co.agro.chain.WebSocketRfidTag.dto;

import java.io.Serializable;

public class OutboundMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -995748334825301191L;
	private String idUsuario;
	private String etiquetaRfid;

	
	public OutboundMessage(String idUsuario, String etiquetaRfid) {
		super();
		this.idUsuario = idUsuario;
		this.etiquetaRfid = etiquetaRfid;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEtiquetaRfid() {
		return etiquetaRfid;
	}

	public void setEtiquetaRfid(String etiquetaRfid) {
		this.etiquetaRfid = etiquetaRfid;
	}

}
