package co.agro.chain.ServicioVinculacionDispositivo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.agro.chain.WebSocketRfidTag.dto.InboundMessage;
import co.agro.chain.WebSocketRfidTag.dto.OutboundMessage;

@RestController
public class RfidDeviceController {

	@PostMapping(value="/rfid/sendRfidId")
	public OutboundMessage captureRfidTAg(@RequestBody InboundMessage message) {
		WsClient.sendBroadcastMessage(message);
		return new OutboundMessage(message.getIdUsuario(), message.getEtiquetaRfid());
	}
}
