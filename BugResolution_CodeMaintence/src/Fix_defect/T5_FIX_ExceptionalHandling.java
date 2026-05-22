public ValidationResult validate(Document doc) {
    try {
        // FIX: Use specific exception types for validation failures
        if (doc == null) {
            throw new IllegalArgumentException("Document is null");
        }

        String content = doc.extractContent();

        if (content == null || content.isEmpty()) {
            // FIX: Throw meaningful validation exception instead of generic RuntimeException
            throw new IllegalArgumentException("Empty content");
        }

        return runValidationRules(content);

    } catch (IllegalArgumentException e) {
        // FIX: Avoid printStackTrace(); log concise validation message for expected failures
        logger.warn("Validation failed: {}", e.getMessage());
        return ValidationResult.invalid(e.getMessage());

    } catch (Exception e) {
        // FIX: Do not swallow unexpected system errors; log properly and rethrow
        logger.error("Unexpected error during document validation", e);
        throw new ValidationException("Validation processing failed", e);
    }
}

public void validateBatch(List<Document> docs) {

    if (docs == null || docs.isEmpty()) {
        return;
    }

    for (Document doc : docs) {
        try {
            ValidationResult r = validate(doc);

            // FIX: Prevent NullPointerException by checking result before use
            if (r != null && r.isValid()) {
                saveResult(r);
            }

        } catch (ValidationException | IllegalArgumentException e) {
            // FIX: Do not silently swallow exceptions; log batch validation failures
            logger.warn("Skipping invalid document: {}", e.getMessage());

        } catch (Exception e) {
            logger.error("Unexpected batch validation error", e);
        }
    }
}