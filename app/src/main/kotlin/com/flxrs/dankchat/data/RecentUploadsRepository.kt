package com.flxrs.dankchat.data

import com.flxrs.dankchat.data.api.dto.UploadDto
import com.flxrs.dankchat.data.database.RecentUploadsDao
import com.flxrs.dankchat.data.database.UploadEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecentUploadsRepository @Inject constructor(
    private val recentUploadsDao: RecentUploadsDao
) {

    fun getRecentUploads(): Flow<List<UploadEntity>> = recentUploadsDao.getRecentUploads()

    suspend fun addUpload(upload: UploadDto) {
        val entity = UploadEntity(
            id = 0,
            timestamp = upload.timestamp,
            imageLink = upload.imageLink,
            deleteLink = upload.deleteLink
        )
        recentUploadsDao.addUpload(entity)
    }

    suspend fun clearUploads() = recentUploadsDao.clearUploads()
}