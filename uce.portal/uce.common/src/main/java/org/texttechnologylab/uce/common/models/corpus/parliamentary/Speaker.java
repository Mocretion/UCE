package org.texttechnologylab.uce.common.models.corpus.parliamentary;

import lombok.Getter;
import lombok.Setter;
import org.texttechnologylab.uce.common.annotations.Typesystem;
import org.texttechnologylab.uce.common.models.ModelBase;
import org.texttechnologylab.uce.common.models.corpus.Document;

import javax.persistence.*;

/**
 * Represents a parliamentary speaker.
 * Note: Speaker extends AnnotationBase in UIMA (not Annotation), so it has no begin/end offsets.
 * It's document-level metadata about who spoke in the session.
 */
@Getter
@Setter
@Entity
@Table(name = "parliamentary_speaker")
@Typesystem(types = {org.texttechnologylab.annotation.parliamentary.Speaker.class})
public class Speaker extends ModelBase {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

    @Column(name = "speaker_id")
    private String speakerId;

    private String firstName;

    private String lastName;

    /**
     * Political party/faction (e.g., "SPD", "CDU/CSU")
     */
    @Column(name = "\"group\"")
    private String group;

    private String role;

    public Speaker() {}

    public String getFullName() {
        if (firstName != null && lastName != null) {
            return firstName + " " + lastName;
        }
        return lastName != null ? lastName : firstName;
    }
}