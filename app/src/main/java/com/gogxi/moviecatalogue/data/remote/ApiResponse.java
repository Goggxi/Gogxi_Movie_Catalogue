package com.gogxi.moviecatalogue.data.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.gogxi.moviecatalogue.data.remote.Status.EMPTY;
import static com.gogxi.moviecatalogue.data.remote.Status.ERROR;
import static com.gogxi.moviecatalogue.data.remote.Status.SUCCESS;

public class ApiResponse <T> {
    @NonNull
    public final Status status;

    @Nullable
    public final String message;

    @Nullable
    public final T body;

    private ApiResponse(@NonNull Status statusResponse, @Nullable String message, @Nullable T body) {
        this.status = statusResponse;
        this.message = message;
        this.body = body;
    }

    public static <T> ApiResponse success(@Nullable T body) {
        return new ApiResponse<>(SUCCESS, null, body);
    }

    public static <T> ApiResponse empty(String message, @Nullable T body) {
        return new ApiResponse<>(EMPTY, message, body);
    }

    public static <T> ApiResponse error(String message, @Nullable T body) {
        return new ApiResponse<>(ERROR, message, body);
    }
}
