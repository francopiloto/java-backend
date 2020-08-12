package demo.server.utils;

public class JsonBuilder
{
    private StringBuilder sb = new StringBuilder("{");

/* --------------------------------------------------------------------------------------------- */

    public JsonBuilder add(Object key, int value)
    {
        sb.append("\"").append(key).append("\":").append(value).append(",");
        return this;
    }

/* --------------------------------------------------------------------------------------------- */

    public JsonBuilder add(Object key, boolean value)
    {
        sb.append("\"").append(key).append("\":").append(value).append(",");
        return this;
    }

/* --------------------------------------------------------------------------------------------- */

    public JsonBuilder add(Object key, Object value)
    {
        sb.append("\"").append(key).append("\":\"").append(value).append("\",");
        return this;
    }

/* --------------------------------------------------------------------------------------------- */

    public String build()
    {
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 1);
        }

        return sb.append('}').toString();
    }

/* --------------------------------------------------------------------------------------------- */

}
