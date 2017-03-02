package dhu.cst.zjm.encryptmvp.mvp.presenter;


import dhu.cst.zjm.encryptmvp.domain.LoginInternetUseCase;
import dhu.cst.zjm.encryptmvp.mvp.contract.LoginContract;
import dhu.cst.zjm.encryptmvp.mvp.model.User;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by zjm on 2017/2/24.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginInternetUseCase mLoginInternetUseCase;
    private LoginContract.View mView;
    private CompositeSubscription mCompositeSubscription;

    public LoginPresenter(LoginInternetUseCase loginInternetUseCase) {
        this.mLoginInternetUseCase = loginInternetUseCase;
    }

    @Override
    public void attachView(LoginContract.View BaseView) {
        mView = BaseView;
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        if (mCompositeSubscription != null && mCompositeSubscription.isUnsubscribed()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void loginInternet(String id, String password) {
        User user;
        try {
            user = new User(Integer.parseInt(id), password);
        } catch (Exception e) {
            e.printStackTrace();
            mView.loginEmptyError();
            return;
        }
        mLoginInternetUseCase.setUser(user);
        Subscription subscription = mLoginInternetUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.loginNetworkError();
                    }

                    @Override
                    public void onNext(User user) {
                        mView.getLoginState(user);
                    }

                });
        mCompositeSubscription.add(subscription);

    }
}