package co.agro.chain.ServicioVinculacionDispositivo;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.ClientEndpoint;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import com.google.gson.Gson;

import co.agro.chain.WebSocketRfidTag.dto.InboundMessage;

@ClientEndpoint
public class WsClient {

	private static StompSession wsSesion;

	public WsClient() {

	}

	public static void sendBroadcastMessage(final InboundMessage inMessage) {
		try {
			if (wsSesion == null || !wsSesion.isConnected()) {
				WebSocketClient wsClient = new StandardWebSocketClient();
				List<Transport> transports = new ArrayList<>(1);
				transports.add(new WebSocketTransport(wsClient));
				SockJsClient sockJsClient = new SockJsClient(transports);
				WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
				stompClient.setMessageConverter(new MappingJackson2MessageConverter());
				String url = "ws://localhost:8089/rfid-devices-websocket";
				StompSessionHandler sessionHandler = new SessionHandler();
				wsSesion = stompClient.connect(url, sessionHandler).get();
				wsSesion.subscribe("/topic/rfidInfo", sessionHandler);
			}
			final Gson gson = new Gson();
			final String rfidData = gson.toJson(inMessage);
			wsSesion.send("/app/sendRfidTag", rfidData);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
