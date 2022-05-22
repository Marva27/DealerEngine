package com.dealerengine.www.api;

import com.dealerengine.www.model.AdminUser;
import com.dealerengine.www.model.Error;
import com.dealerengine.www.model.SignInRequest;
import com.dealerengine.www.model.Token;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link UsersApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-20T16:17:24.620-05:00[America/Chicago]")
public interface UsersApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /users/adminUserSignIn : Admin User SignIn
     * To signin an admin user
     *
     * @param signInRequest Admin User SignIn Request (optional)
     * @return Admin user signed in successfully (status code 200)
     *         or Authentication failed (status code 401)
     * @see UsersApi#adminUserSignIn
     */
    default ResponseEntity<Token> adminUserSignIn(SignInRequest signInRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"userName\" : \"userName\", \"jwtCode\" : \"jwtCode\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /users/adminUserSignUp : Admin User SignUp
     * To signup a new admin user
     *
     * @param adminUser Admin User SignUp Request (optional)
     * @return Admin user created successfully (status code 200)
     *         or Error in signing up new admin user (status code 400)
     * @see UsersApi#adminUserSignUp
     */
    default ResponseEntity<AdminUser> adminUserSignUp(AdminUser adminUser) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"emailAddress\" : \"emailAddress\", \"password\" : \"password\", \"userName\" : \"userName\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
