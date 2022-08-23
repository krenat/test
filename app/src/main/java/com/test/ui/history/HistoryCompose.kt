package com.test.ui.history

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.skydoves.landscapist.glide.GlideImage
import com.test.R
import com.test.model.User

@Composable
fun HistoryScreen(viewModel: HistoryViewModel) {
    val users: List<User> = viewModel.historyUsers

    if(users.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("History is empty")
        }
    } else {
        LazyColumn(Modifier.padding(horizontal = 16.dp)) {
            items(users.size) {
                UserItem(users[it])
            }
        }
    }
}

@Composable
private fun UserItem(user: User) {
    Row(
        Modifier.padding(8.dp)
    ) {
        GlideImage(
            user.picture.thumbnail,
            requestOptions = {
                RequestOptions.bitmapTransform(RoundedCorners(8))
            },
            previewPlaceholder = R.drawable.ic_smile,
            modifier = Modifier.width(36.dp).height(36.dp)
        )
        Column(Modifier.padding(4.dp)) {
            Text(
                text = user.getName(),
                color = colorResource(R.color.text)
            )
            Text(
                text = user.cell,
                color = colorResource(R.color.text)
            )
            Text(
                text = user.email,
                color = colorResource(R.color.text)
            )
        }
    }
}