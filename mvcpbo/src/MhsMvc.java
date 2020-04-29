
/**
 *
 * @author desii
 */
public class MhsMvc {
    MhsView mhsview = new MhsView();
    MhsModel mhsmodel = new MhsModel();
    MhsDao mhsdao = new MhsDao();
    
    MhsController mhscontroller = new MhsController(mhsmodel,mhsview,mhsdao);
}
