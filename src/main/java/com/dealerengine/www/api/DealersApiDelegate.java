package com.dealerengine.www.api;

import com.dealerengine.www.model.Dealer;
import com.dealerengine.www.model.Error;
import com.dealerengine.www.model.Information;
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
 * A delegate to be called by the {@link DealersApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-20T16:17:24.620-05:00[America/Chicago]")
public interface DealersApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /dealers/addNew : Add New Dealer
     * To add a new dealer
     *
     * @param dealer Dealer Details (optional)
     * @return Dealer added successfully (status code 200)
     *         or Error in adding dealer (status code 400)
     *         or User not authorized for adding dealer (status code 401)
     * @see DealersApi#addNewDealer
     */
    default ResponseEntity<Dealer> addNewDealer(Dealer dealer) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"dealerName\" : \"dealerName\", \"dealerZipCode\" : 6, \"dealerAddress\" : \"dealerAddress\", \"dealerId\" : 0, \"dealerCity\" : \"dealerCity\", \"dealerState\" : \"dealerState\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /dealers/{dealerId} : Delete Existing Dealer
     * To delete an existing dealer
     *
     * @param dealerId Unique id of the dealer (required)
     * @return Dealer deleted successfully (status code 200)
     *         or User not authorized for deleting dealer (status code 401)
     *         or Dealer not found (status code 404)
     * @see DealersApi#deleteExistingDealer
     */
    default ResponseEntity<Information> deleteExistingDealer(Integer dealerId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /dealers/{dealerId} : Get Existing Dealer
     * To get an existing dealer
     *
     * @param dealerId Unique id of the dealer (required)
     * @return Dealer retrieved successfully (status code 200)
     *         or Dealer not found (status code 404)
     * @see DealersApi#getExistingDealer
     */
    default ResponseEntity<Dealer> getExistingDealer(Integer dealerId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"dealerName\" : \"dealerName\", \"dealerZipCode\" : 6, \"dealerAddress\" : \"dealerAddress\", \"dealerId\" : 0, \"dealerCity\" : \"dealerCity\", \"dealerState\" : \"dealerState\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /dealers/{dealerId} : Update Existing Dealer
     * To update an existing dealer
     *
     * @param dealerId Unique id of the dealer (required)
     * @param dealer  (optional)
     * @return Dealer updated successfully (status code 200)
     *         or Error in updating dealer (status code 400)
     *         or User not authorized for updating dealer (status code 401)
     *         or Dealer not found (status code 404)
     * @see DealersApi#updateExistingDealer
     */
    default ResponseEntity<Dealer> updateExistingDealer(Integer dealerId,
        Dealer dealer) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"dealerName\" : \"dealerName\", \"dealerZipCode\" : 6, \"dealerAddress\" : \"dealerAddress\", \"dealerId\" : 0, \"dealerCity\" : \"dealerCity\", \"dealerState\" : \"dealerState\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
