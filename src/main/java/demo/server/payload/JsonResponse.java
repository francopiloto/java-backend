package demo.server.payload;

import org.springframework.http.HttpStatus;

public class JsonResponse
{
    private final Object body;
    private final HttpStatus status;

/* --------------------------------------------------------------------------------------------- */

    public JsonResponse() {
        this(null, HttpStatus.OK);
    }

/* --------------------------------------------------------------------------------------------- */

    public JsonResponse(Object body) {
        this(body, HttpStatus.OK);
    }

/* --------------------------------------------------------------------------------------------- */

    public JsonResponse(HttpStatus status) {
        this(null, status);
    }

/* --------------------------------------------------------------------------------------------- */

    public JsonResponse(Object body, HttpStatus status)
    {
        this.body = body;
        this.status = status;
    }

/* --------------------------------------------------------------------------------------------- */

    public Object getBody() {
        return body;
    }

/* --------------------------------------------------------------------------------------------- */

    public HttpStatus getStatus() {
        return status;
    }

/* --------------------------------------------------------------------------------------------- */

}
