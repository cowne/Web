import com.thinhnee.loginpagedemo.dao.ImageDAO;
import com.thinhnee.loginpagedemo.entity.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        List<Image> list = ImageDAO.getAllImage("wiener");
        for(Image o : list){
            System.out.println(o);
        }
    }
}
