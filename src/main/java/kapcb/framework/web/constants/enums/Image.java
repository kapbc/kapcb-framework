package kapcb.framework.web.constants.enums;

/**
 * <a>Title: ImageEnum </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/11 15:16
 */
public class Image {

    public enum Type {

        PNG("png", "image with png"),
        JPG("jpg", "image with jpg"),
        JPEG("jpeg", "image with jpeg"),
        GIF("gif", "image with gif"),
        ICO("ico", "image with ico");

        private String type;
        private String description;

        Type(String type, String description) {
            this.type = type;
            this.description = description;
        }

        public String type() {
            return this.type;
        }
    }
}
