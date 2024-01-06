import com.thinhnee.model.image.ImageDAO;
import com.thinhnee.model.image.ImageModel;
import com.thinhnee.model.note.Note;
import com.thinhnee.model.note.NoteDAO;
import com.thinhnee.model.user.DAO;
import com.thinhnee.model.user.UserModel;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ImageDAO.deleteImage(6,"wiener");
    }
}
