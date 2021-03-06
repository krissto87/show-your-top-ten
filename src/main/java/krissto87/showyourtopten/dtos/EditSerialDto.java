package krissto87.showyourtopten.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class EditSerialDto {

    private Long id;
    @NotBlank
    @Size(min = 2, max = 30)
    private String title;
    @NotBlank
    private String type;
    private String creator;
    private String description;
}
