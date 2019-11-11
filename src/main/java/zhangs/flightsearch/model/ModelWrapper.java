package zhangs.flightsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Data
public class ModelWrapper<ModelType> {
    private ModelType model;
    private boolean noResult;
    private String message;
}
