package dhu.cst.zjm.encryptmvp.mvp.contract;

import dhu.cst.zjm.encryptmvp.mvp.model.User;
import dhu.cst.zjm.encryptmvp.mvp.presenter.BasePresenter;
import dhu.cst.zjm.encryptmvp.mvp.view.BaseView;

/**
 * Created by zjm on 2017/2/24.
 */

public interface LoginContract {
    interface View extends BaseView {
        void getLoginState(User user);

        void loginNetworkError();

        void loginPasswordError();

        void loginExistError();

        void loginEmptyError();
    }

    interface Presenter extends BasePresenter<View> {
        void loginInternet(String id, String password);
    }
}