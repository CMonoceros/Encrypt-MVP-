package dhu.cst.zjm.encryptmvp.domain.base;

import rx.Observable;

/**
 * Created by zjm on 3/23/2017.
 */

public interface BaseFileUseCase<File> {
    Observable<File> uploadFile();
}
