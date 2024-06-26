package com.lucky7.parky.features.auth.data.repository;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.lucky7.parky.core.callback.RepositoryCallback;
import com.lucky7.parky.features.auth.data.data_source.remote.UserRemoteDataSource;
import com.lucky7.parky.features.auth.data.model.UserModel;
import com.lucky7.parky.features.auth.domain.repository.UserRepository;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

public class UserRepositoryImpl implements UserRepository {
    private final UserRemoteDataSource userRemoteDataSource;

    @Inject
    public UserRepositoryImpl(UserRemoteDataSource userRemoteDataSource) {
        this.userRemoteDataSource = userRemoteDataSource;
    }

    @Override
    public void getAllUsers(RepositoryCallback<List<UserModel>> callback) {
        userRemoteDataSource.getAllUsers().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                callback.onSuccess(task.getResult());
            } else {
                callback.onSuccess(task.getResult());
            }
        });
    }

    @Override
    public Task<Void> addUser(UserModel userModel, RepositoryCallback<UserModel> callback) {
        return userRemoteDataSource.addUser(userModel).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                callback.onSuccess(userModel);
            } else {
                callback.onError(task.getException());
            }
        });
    }

    @Override
    public Task<Void> deleteUser(UserModel userModel, RepositoryCallback<Void> callback) {
        return userRemoteDataSource.deleteUser(userModel).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                callback.onSuccess(null);
            } else {
                callback.onError(task.getException());
            }
        });
    }

    @Override
    public void updatePassword(UserModel userModel, RepositoryCallback<Void> callback) {
        userRemoteDataSource.updatePassword(userModel).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                callback.onSuccess(null);
            } else {
                callback.onError(task.getException());
            }
        });
    }

    @Override
    public void updateParkStatus(String userId, String currentDateTime, RepositoryCallback<Void> callback) {
        userRemoteDataSource.updateParkStatus(userId, currentDateTime).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                callback.onSuccess(null);
            } else {
                callback.onError(task.getException());
            }
        });
    }
}
