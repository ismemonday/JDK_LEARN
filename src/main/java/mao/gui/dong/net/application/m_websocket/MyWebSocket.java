package mao.gui.dong.net.application.m_websocket;

import java.net.http.WebSocket;
import java.nio.ByteBuffer;
import java.util.concurrent.CompletableFuture;

/**
 * @author maoguidong
 */
public class MyWebSocket implements WebSocket {
    @Override
    public CompletableFuture<WebSocket> sendText(CharSequence data, boolean last) {
        return null;
    }

    /**
     * Sends binary data with bytes from the given buffer.
     *
     * <p> The data is located in bytes from the buffer's position to its limit.
     * Upon normal completion of a {@code CompletableFuture} returned from this
     * method the buffer will have no remaining bytes. The buffer must not be
     * accessed until after that.
     *
     * <p> The {@code CompletableFuture} returned from this method can
     * complete exceptionally with:
     * <ul>
     * <li> {@link IllegalStateException} -
     *          if there is a pending text or binary send operation
     *          or if the previous textual data does not complete the message
     * <li> {@link IOException} -
     *          if an I/O error occurs, or if the output is closed
     * </ul>
     *
     * @param data the data
     * @param last {@code true} if this invocation completes the message,
     *             {@code false} otherwise
     * @return a {@code CompletableFuture} that completes, with this WebSocket,
     * when the data has been sent
     */
    @Override
    public CompletableFuture<WebSocket> sendBinary(ByteBuffer data, boolean last) {
        return null;
    }

    /**
     * Sends a Ping message with bytes from the given buffer.
     *
     * <p> The message consists of not more than {@code 125} bytes from the
     * buffer's position to its limit. Upon normal completion of a
     * {@code CompletableFuture} returned from this method the buffer will
     * have no remaining bytes. The buffer must not be accessed until after that.
     *
     * <p> The {@code CompletableFuture} returned from this method can
     * complete exceptionally with:
     * <ul>
     * <li> {@link IllegalStateException} -
     *          if there is a pending ping or pong send operation
     * <li> {@link IllegalArgumentException} -
     *          if the message is too long
     * <li> {@link IOException} -
     *          if an I/O error occurs, or if the output is closed
     * </ul>
     *
     * @param message the message
     * @return a {@code CompletableFuture} that completes, with this WebSocket,
     * when the Ping message has been sent
     */
    @Override
    public CompletableFuture<WebSocket> sendPing(ByteBuffer message) {
        return null;
    }

    /**
     * Sends a Pong message with bytes from the given buffer.
     *
     * <p> The message consists of not more than {@code 125} bytes from the
     * buffer's position to its limit. Upon normal completion of a
     * {@code CompletableFuture} returned from this method the buffer will have
     * no remaining bytes. The buffer must not be accessed until after that.
     *
     * <p> Given that the WebSocket implementation will automatically send a
     * reciprocal pong when a ping is received, it is rarely required to send a
     * pong message explicitly.
     *
     * <p> The {@code CompletableFuture} returned from this method can
     * complete exceptionally with:
     * <ul>
     * <li> {@link IllegalStateException} -
     *          if there is a pending ping or pong send operation
     * <li> {@link IllegalArgumentException} -
     *          if the message is too long
     * <li> {@link IOException} -
     *          if an I/O error occurs, or if the output is closed
     * </ul>
     *
     * @param message the message
     * @return a {@code CompletableFuture} that completes, with this WebSocket,
     * when the Pong message has been sent
     */
    @Override
    public CompletableFuture<WebSocket> sendPong(ByteBuffer message) {
        return null;
    }

    /**
     * Initiates an orderly closure of this WebSocket's output by
     * sending a Close message with the given status code and the reason.
     *
     * <p> The {@code statusCode} is an integer from the range
     * {@code 1000 <= code <= 4999}. Status codes {@code 1002}, {@code 1003},
     * {@code 1006}, {@code 1007}, {@code 1009}, {@code 1010}, {@code 1012},
     * {@code 1013} and {@code 1015} are illegal. Behaviour in respect to other
     * status codes is implementation-specific. A legal {@code reason} is a
     * string that has a UTF-8 representation not longer than {@code 123} bytes.
     *
     * <p> A {@code CompletableFuture} returned from this method can
     * complete exceptionally with:
     * <ul>
     * <li> {@link IllegalArgumentException} -
     *           if {@code statusCode} is illegal, or
     *           if {@code reason} is illegal
     * <li> {@link IOException} -
     *           if an I/O error occurs, or if the output is closed
     * </ul>
     *
     * <p> Unless the {@code CompletableFuture} returned from this method
     * completes with {@code IllegalArgumentException}, or the method throws
     * {@code NullPointerException}, the output will be closed.
     *
     * <p> If not already closed, the input remains open until a Close message
     * {@linkplain Listener#onClose(WebSocket, int, String) received}, or
     * {@code abort} is invoked, or an
     * {@linkplain Listener#onError(WebSocket, Throwable) error} occurs.
     *
     * @param statusCode the status code
     * @param reason     the reason
     * @return a {@code CompletableFuture} that completes, with this WebSocket,
     * when the Close message has been sent
     * @apiNote Use the provided integer constant {@link #NORMAL_CLOSURE} as a
     * status code and an empty string as a reason in a typical case:
     * <pre>{@code     CompletableFuture<WebSocket> webSocket = ...
     *    webSocket.thenCompose(ws -> ws.sendText("Hello, ", false))
     *             .thenCompose(ws -> ws.sendText("world!", true))
     *             .thenCompose(ws -> ws.sendClose(WebSocket.NORMAL_CLOSURE, ""))
     *             .join(); }</pre>
     * <p>
     * The {@code sendClose} method does not close this WebSocket's input. It
     * merely closes this WebSocket's output by sending a Close message. To
     * enforce closing the input, invoke the {@code abort} method. Here is an
     * example of an application that sends a Close message, and then starts a
     * timer. Once no data has been received within the specified timeout, the
     * timer goes off and the alarm aborts {@code WebSocket}:
     * <pre>{@code     MyAlarm alarm = new MyAlarm(webSocket::abort);
     *    WebSocket.Listener listener = new WebSocket.Listener() {
     *
     *        public CompletionStage<?> onText(WebSocket webSocket,
     *                                         CharSequence data,
     *                                         boolean last) {
     *            alarm.snooze();
     *            ...
     *        }
     *        ...
     *    };
     *    ...
     *    Runnable startTimer = () -> {
     *        MyTimer idleTimer = new MyTimer();
     *        idleTimer.add(alarm, 30, TimeUnit.SECONDS);
     *    };
     *    webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "ok").thenRun(startTimer);
     * } </pre>
     */
    @Override
    public CompletableFuture<WebSocket> sendClose(int statusCode, String reason) {
        return null;
    }

    /**
     * Increments the counter of invocations of receive methods.
     *
     * <p> This WebSocket will invoke {@code onText}, {@code onBinary},
     * {@code onPing}, {@code onPong} or {@code onClose} methods on the
     * associated listener (i.e. receive methods) up to {@code n} more times.
     *
     * @param n the number of invocations
     * @throws IllegalArgumentException if {@code n <= 0}
     * @apiNote The parameter of this method is the number of invocations being
     * requested from this WebSocket to the associated listener, not the number
     * of messages. Sometimes a message may be delivered to the listener in a
     * single invocation, but not always. For example, Ping, Pong and Close
     * messages are delivered in a single invocation of {@code onPing},
     * {@code onPong} and {@code onClose} methods respectively. However, whether
     * or not Text and Binary messages are delivered in a single invocation of
     * {@code onText} and {@code onBinary} methods depends on the boolean
     * argument ({@code last}) of these methods. If {@code last} is
     * {@code false}, then there is more to a message than has been delivered to
     * the invocation.
     *
     * <p> Here is an example of a listener that requests invocations, one at a
     * time, until a complete message has been accumulated, and then processes
     * the result:
     * <pre>{@code     WebSocket.Listener listener = new WebSocket.Listener() {
     *
     *        StringBuilder text = new StringBuilder();
     *
     *        public CompletionStage<?> onText(WebSocket webSocket,
     *                                         CharSequence message,
     *                                         boolean last) {
     *            text.append(message);
     *            if (last) {
     *                processCompleteTextMessage(text);
     *                text = new StringBuilder();
     *            }
     *            webSocket.request(1);
     *            return null;
     *        }
     *    ...
     *    } } </pre>
     */
    @Override
    public void request(long n) {

    }

    /**
     * Returns the subprotocol used by this WebSocket.
     *
     * @return the subprotocol, or an empty string if there's no subprotocol
     */
    @Override
    public String getSubprotocol() {
        return null;
    }

    /**
     * Tells whether this WebSocket's output is closed.
     *
     * <p> If this method returns {@code true}, subsequent invocations will also
     * return {@code true}.
     *
     * @return {@code true} if closed, {@code false} otherwise
     */
    @Override
    public boolean isOutputClosed() {
        return false;
    }

    /**
     * Tells whether this WebSocket's input is closed.
     *
     * <p> If this method returns {@code true}, subsequent invocations will also
     * return {@code true}.
     *
     * @return {@code true} if closed, {@code false} otherwise
     */
    @Override
    public boolean isInputClosed() {
        return false;
    }

    /**
     * Closes this WebSocket's input and output abruptly.
     *
     * <p> When this method returns both the input and the output will have been
     * closed. Any pending send operations will fail with {@code IOException}.
     * Subsequent invocations of {@code abort} will have no effect.
     */
    @Override
    public void abort() {

    }
}
