package com.sampleandroidapp.mobicomp.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sampleandroidapp.mobicomp.data.Reminder
import java.text.SimpleDateFormat
import java.util.*

// Reminder on home page
@Composable
fun Reminders(
    modifier: Modifier = Modifier
) {
    val viewModel: RemindersViewModel = viewModel()
    val viewState by viewModel.state.collectAsState()

    // Defines layout of reminder list
    Column(Modifier.fillMaxWidth()) {
        ReminderList(
            list = viewState.reminders
        )
    }
}
// Defines LazyColumn list for ReminderList
@Composable
private fun ReminderList(
    list: List<Reminder>
) {
    LazyColumn(
        contentPadding = PaddingValues(0.dp),
        verticalArrangement = Arrangement.Center
    ) {
        items(list) { item ->
            ReminderListItem(
                reminder = item,
                onClick = { /*TODO*/ },
                modifier = Modifier.fillParentMaxWidth()
            )
        }
    }
}
// PaymentList Item shown in constraintLayout form
@Composable
private fun ReminderListItem(
    reminder: Reminder,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    // clickable means that the whole payment item line is clickable in list
    ConstraintLayout(modifier = modifier.clickable { onClick() }) {
        val (divider, reminderTitle, date) = createRefs()
        Divider(
            Modifier.constrainAs(divider) {
                top.linkTo(parent.top)
                centerHorizontallyTo(parent)
                width = Dimension.fillToConstraints
            }
        )

        // title on 1st line
        Text(
            text = reminder.reminderTitle,
            maxLines = 1,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.constrainAs(reminderTitle) {
                linkTo(
                    start = parent.start,
                    end = parent.end,    // ARVAUSHEITETTY
                    startMargin = 24.dp,
                    endMargin = 16.dp,
                    bias = 0f // float this towards the start. this was is the fix we needed
                )
                top.linkTo(parent.top, margin = 10.dp)
                width = Dimension.preferredWrapContent
            }
        )

        // date on 2nd line
        Text(
            text = when {
                reminder.reminderDate != null -> {
                    reminder.reminderDate.formatToString()
                }
                else -> Date().formatToString()
            },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.constrainAs(date) {
                linkTo(
                    start = parent.start,
                    end = reminderTitle.end
                    //startMargin = 8.dp,
                    //endMargin = 16.dp,
                    //bias = 0f // float this towards the start. this was is the fix we needed
                    //)
                )
                centerVerticallyTo(reminderTitle)
                top.linkTo(reminderTitle.bottom, 6.dp)
                bottom.linkTo (parent.bottom, 10.dp)
            }
        )
    }
}

private fun Date.formatToString(): String {
    return SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault()).format(this)
    }