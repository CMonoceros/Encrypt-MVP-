package dhu.cst.zjm.encryptmvp.mvp.contract;

import java.util.List;

import dhu.cst.zjm.encryptmvp.mvp.model.EncryptRelation;
import dhu.cst.zjm.encryptmvp.mvp.model.EncryptType;
import dhu.cst.zjm.encryptmvp.mvp.model.File;
import dhu.cst.zjm.encryptmvp.mvp.presenter.BasePresenter;
import dhu.cst.zjm.encryptmvp.mvp.view.BaseView;
import dhu.cst.zjm.encryptmvp.util.ProgressListener;

/**
 * Created by zjm on 2017/3/3.
 */

public interface FileTypeContract {
    interface View extends BaseView {
        void updateEncryptType(List<EncryptType> list);

        void getFileTypeNetworkError();

        void typeDetailClick(EncryptType encryptType);

        void setFile(File file);

        void downloadFileNetworkError();

        void setDesKey(EncryptRelation encryptRelation);

        void encryptBaseTypeNetworkError();

        void encryptBaseTypeEncryptSuccess();
    }

    interface Presenter extends BasePresenter<View> {
        void getEncryptType();

        void encryptFile(EncryptRelation encryptRelation);

        void encryptBaseType(EncryptRelation encryptRelation,String desKey,String desLayer);

        void downloadFile(File file,ProgressListener listener);
    }
}