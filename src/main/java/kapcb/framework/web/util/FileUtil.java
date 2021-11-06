package kapcb.framework.web.util;

import kapcb.framework.web.constants.enums.StringPool;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;

import java.io.InputStream;
import java.util.Objects;

/**
 * <a>Title: FileUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description: FileUtil <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/6 17:50
 */
@Slf4j
@UtilityClass
public class FileUtil {

    public static InputStream getResourcesFileInputStream(@NonNull String filename) {
        log.info("file name is : {}", filename);
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(StringPool.EMPTY_STRING.value() + filename);
    }

    public static String getPath() {
        String path = Objects.requireNonNull(FileUtil.class.getResource(StringPool.SLASH.value())).getPath();
        log.info("the path is : {}", path);
        return path;
    }

}
