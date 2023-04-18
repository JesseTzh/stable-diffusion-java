package com.jessetzh.handler;

/**
 * Abnormal drawing
 *
 * @author JesseTzh
 */
public class StableDiffusionException extends RuntimeException  {

    private static final long serialVersionUID = 1L;

    public StableDiffusionException(String message) {
        super(message);
    }
}
