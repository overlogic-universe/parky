package com.lucky7.parky.features.auth.domain.repository;

import com.google.android.gms.tasks.Task;
import com.lucky7.parky.core.callback.RepositoryCallback;
import com.lucky7.parky.features.auth.data.model.UserModel;

public interface UserRepository {
    Task<Void> addUser(UserModel userModel,RepositoryCallback<UserModel> callback);
    Task<Void> deleteUser(UserModel userModel, RepositoryCallback<Void> callback);
    void updatePassword(UserModel userModel, RepositoryCallback<Void> callback);
    void updateParkStatus(String userId, String currentDateTime, RepositoryCallback<Void> callback);
}
