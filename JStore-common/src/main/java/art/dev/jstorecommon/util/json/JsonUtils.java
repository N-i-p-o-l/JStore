package art.dev.jstorecommon.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class JsonUtils {

  private JsonUtils() {
  }

  private static class JacksonObjectMapper extends ObjectMapper {

    private static final Logger log = LoggerFactory.getLogger(JacksonObjectMapper.class);

    JacksonObjectMapper() {
      configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }
  }

  public static String toJson(Object value) throws JsonProcessingException {
    JacksonObjectMapper mapper = new JacksonObjectMapper();
    return mapper.writeValueAsString(value);
  }
}
