package com.lucky7.parky.features.auth.domain.repository;

import com.lucky7.parky.core.callback.RepositoryCallback;
import com.lucky7.parky.features.auth.data.model.AdminModel;
import com.lucky7.parky.features.auth.data.model.UserModel;

public interface AuthRepository {
     void loginWithEmailAndPasswordAdmin(AdminModel adminModel, RepositoryCallback<AdminModel> callback);
     void loginWithEmailAndPasswordUser(UserModel userModel, RepositoryCallback<UserModel> callback);
     void signUpWithEmailAndPasswordUser(UserModel userModel, RepositoryCallback<UserModel> callback);
     void getUserFromFirestore(String userId, RepositoryCallback<UserModel> callback);
     void getAdminFromFirestore(String adminId, RepositoryCallback<AdminModel> callback);
     public void saveLoginStatus(boolean isLoggedIn, String userType, String userId);
     public boolean isLoggedIn();
     public String getUserType();
     public String getUserId();
     public void clearLoginStatus();
     void logout();
}
